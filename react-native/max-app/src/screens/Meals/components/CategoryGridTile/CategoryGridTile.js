import { Pressable, Text, View } from "react-native";
import { styles } from "./CategoryGridTile.style";
import { useNavigation } from "@react-navigation/native";

export function CategoryGridTile({ title, color, onPress }) {
  const navigation = useNavigation();

  return (
    <View style={styles.container}>
      <Pressable android_ripple={{ color: '#CCC' }} style={({ pressed }) => [styles.button, pressed ? styles.buttonPressed : styles.button]} onPress={onPress}>
        <View style={[styles.content, { backgroundColor: color }]}>
          <Text style={styles.title}>{title}</Text>
        </View>
      </Pressable>
    </View>
  );
}
