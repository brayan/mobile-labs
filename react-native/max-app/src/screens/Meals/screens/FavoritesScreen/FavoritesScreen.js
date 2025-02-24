import { Text, View } from "react-native";
import { styles } from "./FavoritesScreen.style";
import MealList from "../../components/MealList";
import { useContext } from "react";
import { FavoritesContext } from "../../store/favorites-context";
import { MEALS } from "../../data/dummy-data";
import { useSelector } from "react-redux";

export function FavoritesScreen() {
  // const favoriteMealsContext = useContext(FavoritesContext);
  const favoriteMealIds = useSelector((state) => state.favoriteMeals.ids);
  // const favoriteMeals = MEALS.filter(meal => favoriteMealsContext.ids.includes(meal.id))
  const favoriteMeals = MEALS.filter(meal => favoriteMealIds.includes(meal.id))

  if (favoriteMeals.length === 0) {
    return (
      <View style={styles.container}>
        <Text style={styles.text}>You have no favorite meals yet.</Text>
      </View>
    )
  }

  return <MealList meals={favoriteMeals} />;
}
