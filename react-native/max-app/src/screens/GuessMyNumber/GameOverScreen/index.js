import { Image, StyleSheet, Text, View } from "react-native";
import Title from "../../../components/GuessMyNumber/Title";
import { GuessMyNumberColors } from "../../../contants/colors";
import PrimaryButton from "../../../components/GuessMyNumber/PrimaryButton";

export default function GameOverScreen({ userNumber, guessRounds, onStartNewGame }) {
    return (
        <View style={styles.cointainer}>
            <Title>GAME OVER</Title>
            <View style={styles.imageContainer}>
                <Image
                    style={styles.image}
                    source={require('../../../../assets/images/success.png')}
                />
            </View>
            <Text style={styles.summaryText}>
                Your phone needed <Text style={styles.summaryHighlightText}>{guessRounds}</Text> rounds to guess the number <Text style={styles.summaryHighlightText}>{userNumber}</Text>.
            </Text>
            <PrimaryButton onPress={onStartNewGame}>Start New Game</PrimaryButton>
        </View>
    );
}

const styles = StyleSheet.create({
    cointainer: {
        flex: 1,
        padding: 24,
        justifyContent: 'center',
        alignItems: 'center',
    },
    imageContainer: {
        width: 300,
        height: 300,
        borderRadius: 150,
        borderWidth: 3,
        borderColor: GuessMyNumberColors.primary800,
        overflow: "hidden",
        margin: 36,
    },
    image: {
        width: "100%",
        heigth: "100%",
    },
    summaryText: {
        fontFamily: 'open-sans',
        fontSize: 24,
        marginBottom: 24,
        textAlign: "center",
    },
    summaryHighlightText: {
        fontFamily: 'open-sans-bold',
        color: GuessMyNumberColors.primary500,
    },
});
