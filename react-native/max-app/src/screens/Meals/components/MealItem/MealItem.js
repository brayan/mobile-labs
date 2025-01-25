import { Image, Pressable, Text, View } from "react-native";
import { styles } from "./MealItem.style";

export function MealItem({ meal, onPress }) {
  return (
    <View style={styles.container}>
      <Pressable
        style={({ pressed }) => [styles.pressableContainer, pressed ? styles.buttonPressed : null]}
        android_ripple={{ color: '#CCC' }}
        onPress={onPress}
      >
        <View>
          <Image style={styles.image} source={{ uri: meal.imageUrl }} />
          <Text style={styles.title}>{meal.title}</Text>
        </View>
        <View style={styles.detailsContainer}>
          <Text style={styles.detailsText}>{meal.duration}m</Text>
          <Text style={styles.detailsText}>{meal.complexity}</Text>
          <Text style={styles.detailsText}>{meal.affordability}</Text>
        </View>
      </Pressable>
    </View>
  );
}
