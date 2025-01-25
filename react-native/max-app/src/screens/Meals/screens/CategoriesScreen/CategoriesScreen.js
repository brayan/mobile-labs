import { FlatList, SafeAreaView } from "react-native";
import { CATEGORIES } from "../../data/dummy-data";
import CategoryGridTile from "../../components/CategoryGridTile";
import { useNavigation } from "@react-navigation/native";

export function CategoriesScreen() {
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
      onPress={navigateToCategoryDetails.bind(this, navigation, itemData.item.id)} />
  );
}

function navigateToCategoryDetails(navigation, categoryId) {
  navigation.navigate("CategoryDetails", { categoryId: categoryId });
}
