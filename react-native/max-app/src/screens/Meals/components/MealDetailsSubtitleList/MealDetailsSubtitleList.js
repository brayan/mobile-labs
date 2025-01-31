import { FlatList, Text, View } from "react-native";
import { styles } from "./MealDetailsSubtitleList.style";

export function MealDetailsSubtitleList({ data }) {
  return (
    <FlatList
      data={data}
      keyExtractor={(item, index) => index.toString()}
      renderItem={(itemData) => renderItem(itemData)}
      scrollEnabled={false}
    />
  );
}

const renderItem = ({ item }) => (
  <View style={styles.container}>
    <Text style={styles.listItem}>{item}</Text>
  </View>
);
