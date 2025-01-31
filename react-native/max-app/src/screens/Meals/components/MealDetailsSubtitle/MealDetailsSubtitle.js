import { Text, View } from "react-native";
import { styles } from "./MealDetailsSubtitle.style";

export function MealDetailsSubtitle({ children }) {
  return (
    <View>
      <Text style={styles.subtitle}>{children}</Text>
    </View>
  );
}
