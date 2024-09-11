import { Platform, Pressable, StyleSheet, Text, View } from "react-native";

export default function CategoryGridTile({ title, color, onPress }) {
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

const styles = StyleSheet.create({
  container: {
    flex: 1,
    height: 150,
    borderRadius: 8,
    elevation: 4,
    margin: 16,
    shadowColor: '#000',
    shadowOpacity: 0.25,
    shadowOffset: {
      width: 0,
      height: 2,
    },
    shadowRadius: 8,
    overflow: Platform.select({ android: 'hidden', ios: 'visible' })
  },
  button: {
    flex: 1,
  },
  buttonPressed: {
    opacity: 0.5
  },
  content: {
    flex: 1,
    padding: 16,
    borderRadius: 8,
    justifyContent: 'center',
    alignItems: "center",
  },
  title: {
    fontWeight: "bold",
    fontSize: 18,
  }
});
