import { Text, View } from "react-native";
import { styles } from "./MealDetails.style";

export function MealDetails({ meal }) {
  return (
    <View style={styles.container}>
      <Text style={styles.text}>{meal.duration}m</Text>
      <Text style={styles.text}>{meal.complexity}</Text>
      <Text style={styles.text}>{meal.affordability}</Text>
    </View>
  );
}
