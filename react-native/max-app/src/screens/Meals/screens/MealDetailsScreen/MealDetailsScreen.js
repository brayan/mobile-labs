import { Button, FlatList, Image, ScrollView, Text, View } from "react-native";
import { styles } from "./MealDetailsScreen.style";
import { useNavigation, useRoute } from "@react-navigation/native";
import { MEALS } from "../../data/dummy-data";
import { useContext, useLayoutEffect } from "react";
import MealDetails from "../../components/MealDetails";
import MealDetailsSubtitle from "../../components/MealDetailsSubtitle";
import MealDetailsSubtitleList from "../../components/MealDetailsSubtitleList";
import IconButton from "../../components/IconButton";
import { FavoritesContext } from "../../store/favorites-context";
import { useDispatch, useSelector } from "react-redux";
import { addFavorite, removeFavorite } from "../../store/redux/favorites";

export function MealDetailsScreen() {
  // const favoriteMealsContext = useContext(FavoritesContext);
  const favoriteMealIds = useSelector((state) => state.favoriteMeals.ids);
  const dispatch = useDispatch();

  const route = useRoute();
  const navigation = useNavigation();

  const mealId = route.params.mealId;

  // const isMealFavorite = favoriteMealsContext.ids.includes(mealId);
  const isMealFavorite = favoriteMealIds.includes(mealId);

  const meal = MEALS.find(meal => meal.id === mealId);

  function onPressFavoriteButton() {
    if (isMealFavorite) {
      console.log('Remove favorite');
      // favoriteMealsContext.removeFavorite(mealId);
      dispatch(removeFavorite({ id: mealId }));
    } else {
      console.log('Add favorite');
      dispatch(addFavorite({ id: mealId }));
      // favoriteMealsContext.addFavorite(mealId);
    }
  }

  useLayoutEffect(() => {
    if (!meal) {
      return;
    }

    navigation.setOptions({
      title: meal.title,
      headerRight: () => (
        <IconButton
          icon={isMealFavorite ? 'star' : 'star-outline'}
          color="white"
          onPress={onPressFavoriteButton}
        />
      )
    });
  }, [meal, navigation, onPressFavoriteButton])

  return (
    <ScrollView style={styles.container}>
      <Image style={styles.image} source={{ uri: meal.imageUrl }} />
      <Text style={styles.title}>{meal.title}</Text>
      <MealDetails meal={meal} textStyle={styles.detailText} />
      <MealDetailsSubtitle>Ingredients</MealDetailsSubtitle>
      <MealDetailsSubtitleList data={meal.ingredients} />

      <MealDetailsSubtitle>Steps</MealDetailsSubtitle>
      <MealDetailsSubtitleList data={meal.steps} />
    </ScrollView>
  );
}
