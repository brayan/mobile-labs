import { FlatList, SafeAreaView } from "react-native";
import { CATEGORIES } from "../../data/dummy-data";
import CategoryGridTile from "../../components/CategoryGridTile";
import { useNavigation } from "@react-navigation/native";

export function Categories() {
  const navigation = useNavigation();

  return (
    <SafeAreaView>
      <FlatList
        data={CATEGORIES}
        keyExtractor={(item) => item.id}
        renderItem={(itemData) => renderCategoryItem(itemData, navigation)}
        numColumns={2} />
    </SafeAreaView>
  );
}

function renderCategoryItem(itemData, navigation) {
  return (
    <CategoryGridTile
      title={itemData.item.title}
      color={itemData.item.color}
      onPress={navigateToMealsDetails.bind(this, navigation, itemData.item.id)} />
  );
}

function navigateToMealsDetails(navigation, categoryId) {
  navigation.navigate("MealsDetails", { categoryId: categoryId });
}
