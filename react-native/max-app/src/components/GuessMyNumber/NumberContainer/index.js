import { StyleSheet, Text, View } from "react-native";
import { GuessMyNumberColors } from "../../../contants/colors";

export default function NumberContainer({ children }) {
    return (
        <View style={styles.container}>
            <Text style={styles.numberText}>{children}</Text>
        </View>
    );
}

const styles = StyleSheet.create({
    container: {
        padding: 24,
        margin: 24,
        borderWidth: 4,
        borderRadius: 8,
        borderColor: GuessMyNumberColors.accent500,
        alignItems: "center",
        justifyContent: "center",
    },
    numberText: {
        fontFamily: 'open-sans-bold',
        color: GuessMyNumberColors.accent500,
        fontSize: 36,
    },
});
