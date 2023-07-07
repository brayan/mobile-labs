import React from "react";
import { Text, TouchableOpacity } from "react-native";
import styles from "./styles";

export default function CustomButton({ text }) {
    return <>
        <TouchableOpacity style={styles.button}>
            <Text style={styles.text}>{text}</Text>
        </TouchableOpacity>
    </>
}
