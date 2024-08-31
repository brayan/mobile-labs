import { Alert, FlatList, StyleSheet, Text, View } from "react-native";
import Title from "../../../components/GuessMyNumber/Title";
import { GuessMyNumberColors } from "../../../contants/colors";
import { useEffect, useState } from "react";
import NumberContainer from "../../../components/GuessMyNumber/NumberContainer";
import PrimaryButton from "../../../components/GuessMyNumber/PrimaryButton";
import Card from "../../../components/GuessMyNumber/Card";
import InstructionText from "../../../components/GuessMyNumber/InstructionText";
import Ionicons from '@expo/vector-icons/Ionicons';
import GuessLogItem from "../../../components/GuessMyNumber/GuessLogItem";

const MIN_BOUNDARY = 1;
const MAX_BOUNDARY = 100;

let currentMinBoundary = MIN_BOUNDARY;
let currentMaxBoundary = MAX_BOUNDARY;

export default function GameScreen({ userNumber, onGameOver }) {
    const initialGuess = generateRandomBetween(MIN_BOUNDARY, MAX_BOUNDARY, userNumber);
    const [currentGuess, setCurrentGuess] = useState(initialGuess);
    const [guessRounds, setGuessRounds] = useState([]);

    useEffect(() => {
        if (currentGuess === userNumber) {
            onGameOver(guessRounds.length);
        }
    }, [currentGuess, userNumber, onGameOver]);

    useEffect(() => {
        currentMinBoundary = MIN_BOUNDARY;
        currentMaxBoundary = MAX_BOUNDARY;
    }, []);



    return (
        <View style={styles.screen}>
            <Title>Opponent's Guess</Title>
            <NumberContainer>{currentGuess}</NumberContainer>
            <Card>
                <InstructionText style={styles.instructionText}>Higher or lower?</InstructionText>
                <View style={styles.buttonsContainer}>
                    <View style={styles.buttonContainer}>
                        <PrimaryButton onPress={onHandleNextGuess.bind(this, 'lower', userNumber, currentGuess, setCurrentGuess, setGuessRounds)}>
                            <Ionicons name="remove" size={24} color="white" />
                        </PrimaryButton>
                    </View>
                    <View style={styles.buttonContainer}>
                        <PrimaryButton onPress={onHandleNextGuess.bind(this, 'greater', userNumber, currentGuess, setCurrentGuess, setGuessRounds)}>
                            <Ionicons name="add" size={24} color="white" />
                        </PrimaryButton>
                    </View>
                </View>
            </Card>
            <View style={styles.listContainer}>
                <FlatList
                    data={guessRounds}
                    keyExtractor={(item) => item}
                    renderItem={(itemData) => {
                        return <GuessLogItem roundNumber={guessRounds.length - itemData.index} guess={itemData.item} />
                    }}
                />
            </View>
            {/* {guessRounds.map(guessRound => <Text key={guessRound}>{guessRound}</Text>)} */}
        </View>
    );
}

const styles = StyleSheet.create({
    screen: {
        flex: 1,
        padding: 24,
    },
    title: {
        fontSize: 18,
        fontWeight: 'bold',
        color: GuessMyNumberColors.accent500,
        textAlign: "center",
        borderWidth: 2,
        borderColor: GuessMyNumberColors.accent500,
        padding: 8,
    },
    buttonsContainer: {
        flexDirection: "row"
    },
    buttonContainer: {
        flex: 1,
    },
    instructionText: {
        marginBottom: 12,
    },
    listContainer: {
        flex: 1,
        padding: 16,
    },
});

function onHandleNextGuess(direction, userNumber, currentGuess, setCurrentGuess, setGuessRounds) {
    const isLower = direction === 'lower' && currentGuess < userNumber;
    const isGreater = direction === 'greater' && currentGuess > userNumber;

    if (isLower || isGreater) {
        Alert.alert("Don't lie!", "You know that this is wrong...", [{ text: "Sorry!", style: "cancel" }]);
        return;
    }

    if (direction === 'lower') {
        currentMaxBoundary = currentGuess;
    } else {
        currentMinBoundary = currentGuess + 1;
    }
    const newGuess = generateRandomBetween(currentMinBoundary, currentMaxBoundary, currentGuess);
    setCurrentGuess(newGuess);
    setGuessRounds(prevGuessRounds => [newGuess, ...prevGuessRounds]);
};

function generateRandomBetween(min, max, exclude) {
    let randomNumber = 0

    do {
        randomNumber = Math.floor(Math.random() * (max - min)) + min;
    } while (randomNumber === exclude);

    return randomNumber;
}
