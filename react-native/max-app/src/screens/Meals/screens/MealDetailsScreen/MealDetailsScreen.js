import { FlatList, Image, ScrollView, Text, View } from "react-native";
import { styles } from "./MealDetailsScreen.style";
import { useNavigation, useRoute } from "@react-navigation/native";
import { MEALS } from "../../data/dummy-data";
import { useLayoutEffect } from "react";
import MealDetails from "../../components/MealDetails";

export function MealDetailsScreen() {
  const route = useRoute();
  const navigation = useNavigation();

  const mealId = route.params.mealId;

  const meal = MEALS.find(meal => meal.id === mealId);

  useLayoutEffect(() => {
    navigation.setOptions({
      title: meal.title,
    });
  }, [mealId, navigation])

  return (
    <ScrollView style={styles.container}>
      <Image source={{ uri: meal.imageUrl }} />
      <Text>{meal.title}</Text>
      <MealDetails meal={meal} />
      <Text>Ingredients</Text>
      <FlatList
        data={meal.ingredients}
        keyExtractor={(item, index) => index.toString()}
        renderItem={(itemData) => renderIngredientItem(itemData)}
        scrollEnabled={false}
      />

      <Text>Steps</Text>
      <FlatList
        data={meal.steps}
        keyExtractor={(item, index) => index.toString()}
        renderItem={(itemData) => renderStepItem(itemData)}
        scrollEnabled={false}
      />
    </ScrollView>
  );
}

 const renderIngredientItem = ({ item }) => (
  <View style={styles.listItem}>
    <Text>{item}</Text>
  </View>
);

const renderStepItem = ({ item, index }) => (
  <View style={styles.listItem}>
    <Text>{`${index + 1}. ${item}`}</Text>
  </View>
);
