import { FlatList, SafeAreaView } from "react-native";
import { CATEGORIES } from "../../data/dummy-data";
import CategoryGridTile from "../../components/CategoryGridTile";

export default function Categories() {
  return (
    <SafeAreaView>
      <FlatList
        data={CATEGORIES}
        keyExtractor={(item) => item.id}
        renderItem={renderCategoryItem}
        numColumns={2} />
    </SafeAreaView>
  );
}

function renderCategoryItem(itemData) {
  return (
    <CategoryGridTile
      title={itemData.item.title}
      color={itemData.item.color}
      onPress={() => { console.log('onPress ' + itemData.item.title + ' ' + itemData.item.color) }} />
  );
}
