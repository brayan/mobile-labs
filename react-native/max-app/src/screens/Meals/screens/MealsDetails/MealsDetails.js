import { Text, View } from "react-native";
import { styles } from "./MealsDetails.style";
import { useRoute } from "@react-navigation/native";

export function MealsDetails(/*{ route }*/) {
  const route = useRoute();
  const categoryId = route.params.categoryId;

  return (
    <View style={styles.container}>
      <Text>Meals Details Screen - {categoryId}</Text>
    </View>
  );
}
