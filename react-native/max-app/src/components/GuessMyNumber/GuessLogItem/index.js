import { Text, View, StyleSheet } from "react-native";
import { GuessMyNumberColors } from "../../../contants/colors";

export default function GuessLogItem({ roundNumber, guess }) {
    return (
        <View style={styles.container}>
            <Text style={styles.text}>#{roundNumber}</Text>
            <Text style={styles.text}>Opponent's Guess: {guess}</Text>
        </View>
    );
}

const styles = StyleSheet.create({
    container: {
        flexDirection: "row",
        justifyContent: "space-between",
        width: '100%',
        borderColor: GuessMyNumberColors.primary800,
        borderWidth: 1,
        borderRadius: 40,
        padding: 12,
        marginVertical: 8,
        backgroundColor: GuessMyNumberColors.accent500,
        elevation: 4,
        shadowColor: 'black',
        shadowOffset: { width: 0, height: 0 },
        shadowOpacity: 0.25,
        shadowRadius: 3,
    },
    text: {
        fontFamily: 'open-sans',
    }
});