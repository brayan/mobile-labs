import { Pressable, View } from "react-native";
import { Ionicons } from "@expo/vector-icons";
import { styles } from "./IconButton.style";

export function IconButton({ icon, color, onPress }) {
  return (
    <Pressable onPress={onPress} style={({ pressed }) => pressed && styles.pressed}>
      <Ionicons name={icon} size={24} color={color} />
    </Pressable>
  );
}
