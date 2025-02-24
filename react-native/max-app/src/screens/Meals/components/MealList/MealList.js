import { FlatList, Text, View } from "react-native";
import { styles } from "./MealList.style";
import MealItem from "../MealItem";
import { useNavigation } from "@react-navigation/native";

export function MealList({ meals }) {
  const navigation = useNavigation();

  return (
    <View style={styles.container}>
      <FlatList
        data={meals}
        keyExtractor={(item) => item.id}
        renderItem={(itemData) => renderMealItem(itemData.item, navigation)} />
    </View>
  );
}

function renderMealItem(item, navigation) {
  // console.log(JSON.stringify(item, null, 2));
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
