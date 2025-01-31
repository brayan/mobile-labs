import { Button, FlatList, Image, ScrollView, Text, View } from "react-native";
import { styles } from "./MealDetailsScreen.style";
import { useNavigation, useRoute } from "@react-navigation/native";
import { MEALS } from "../../data/dummy-data";
import { useLayoutEffect } from "react";
import MealDetails from "../../components/MealDetails";
import MealDetailsSubtitle from "../../components/MealDetailsSubtitle";
import MealDetailsSubtitleList from "../../components/MealDetailsSubtitleList";
import IconButton from "../../components/IconButton";

export function MealDetailsScreen() {
  const route = useRoute();
  const navigation = useNavigation();

  const mealId = route.params.mealId;

  const meal = MEALS.find(meal => meal.id === mealId);

  useLayoutEffect(() => {
    if (!meal) {
      return;
    }

    navigation.setOptions({
      title: meal.title,
      headerRight: () => renderHeaderButton()
    });
  }, [meal, navigation])

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

function renderHeaderButton() {
  return (
    <IconButton
      icon="star"
      color="white"
      onPress={() => { console.log("PRESSED!") }}
    />
  );
}
