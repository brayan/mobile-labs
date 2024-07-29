import { StyleSheet, Text, View, Pressable } from 'react-native';

export default function GoalItem(props) {
    return (
        <View style={styles.goalItem}>
            <Pressable
                android_ripple={{ color: '#DDDDDD' }}
                onPress={props.onPressGoal.bind(this, props.item.id)}
                style={({ pressed }) => pressed && styles.pressedItem}>
                <Text style={styles.goalText}>{props.item.text}</Text>
            </Pressable>
        </View>
    );
};

const styles = StyleSheet.create({
    goalItem: {
        margin: 8,
        borderRadius: 6,
        backgroundColor: '#5E08CC'
    },
    goalText: {
        padding: 8,
        color: 'white'
    },
    pressedItem: {
        opacity: 0.5,
    }
});