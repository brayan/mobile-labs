import { Text, View } from "react-native";
import { styles } from "./MealDetails.style";

export function MealDetails({ meal, style, textStyle }) {
  return (
    <View style={[styles.container, style]}>
      <Text style={[styles.text, textStyle]}>{meal.duration}m</Text>
      <Text style={[styles.text, textStyle]}>{meal.complexity}</Text>
      <Text style={[styles.text, textStyle]}>{meal.affordability}</Text>
    </View>
  );
}
