import { StyleSheet, ImageBackground, SafeAreaView } from 'react-native';
import { LinearGradient } from 'expo-linear-gradient';
import { useEffect, useState } from 'react';
import { useFonts } from 'expo-font';
import StartGameScreen from './StartGameScreen';
import { GuessMyNumberColors } from '../../contants/colors';
import GameScreen from './GameScreen';
import GameOverScreen from './GameOverScreen';
import AppLoading from 'expo-app-loading';
import * as SplashScreen from 'expo-splash-screen';

export default function GuessMyNumber() {
    const [userNumber, setUserNumber] = useState();
    const [isGameOver, setIsGameOver] = useState(false);
    const [guessRounds, setGuessRounds] = useState(0);

    const [fontsLoaded] = useFonts({
        'open-sans': require('../../../assets/fonts/OpenSans-Regular.ttf'),
        'open-sans-bold': require('../../../assets/fonts/OpenSans-Bold.ttf'),
    });

    const onPickNumber = (number) => {
        setUserNumber(number);
    };

    if (!fontsLoaded) {
        return <AppLoading />
    }

    let screen = <StartGameScreen onPickNumber={onPickNumber} />

    if (userNumber) {
        screen = <GameScreen
            userNumber={userNumber}
            onGameOver={onGameOver.bind(this, setIsGameOver, setGuessRounds)} />
    }

    if (isGameOver && userNumber) {
        screen = <GameOverScreen
            userNumber={userNumber}
            guessRounds={guessRounds}
            onStartNewGame={onStartNewGame.bind(this, setUserNumber, setGuessRounds, setIsGameOver)}
        />
    }

    return (
        <LinearGradient colors={[GuessMyNumberColors.primary700, GuessMyNumberColors.accent500]} style={styles.rootScreen}>
            <ImageBackground
                source={require('../../../assets/images/background.png')}
                resizeMode='cover'
                style={styles.rootScreen}
                imageStyle={styles.backgroundImage}>
                <SafeAreaView style={styles.rootScreen}>{screen}</SafeAreaView>
            </ImageBackground>
        </LinearGradient>
    );
}

function onGameOver(setIsGameOver, setGuessRounds, numberOfRounds) {
    setIsGameOver(true);
    setGuessRounds(numberOfRounds);
}

function onStartNewGame(setUserNumber, setGuessRounds, setIsGameOver) {
    setUserNumber(null);
    setGuessRounds(0);
    setIsGameOver(false);
}

const styles = StyleSheet.create({
    rootScreen: {
        flex: 1,
    },
    backgroundImage: {
        opacity: 0.15
    }
});
