import { FlatList, Text, View } from "react-native";
import { useNavigation, useRoute } from "@react-navigation/native";
import { CATEGORIES, MEALS } from "../../data/dummy-data";
import MealItem from "../../components/MealItem";
import { useLayoutEffect } from "react";
import { styles } from "./CategoryDetailsScreen.style";
import MealList from "../../components/MealList";

export function CategoryDetailsScreen(/*{ route }*/) {
  const route = useRoute();
  const navigation = useNavigation();

  const categoryId = route.params.categoryId;

  const meals = MEALS.filter((meal) => {
    return meal.categoryIds.indexOf(categoryId) >= 0;
  });

  useLayoutEffect(() => {
    const category = CATEGORIES.find(category => category.id === categoryId);

    navigation.setOptions({
      title: category.title,
    });
  }, [categoryId, navigation])

  return <MealList meals={meals} />
}

function renderMealItem(item, navigation) {
  return (
    <MealItem
      meal={item}
      onPress={onMealPressed.bind(this, item.id, navigation)}
    />
  );
}

function onMealPressed(mealId, navigation) {
  navigation.navigate("MealDetails", { mealId: mealId });
}
