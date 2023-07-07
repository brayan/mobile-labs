import React from "react";
import { Text } from "react-native";
import styles from "./styles";

export default function CustomText({ children, style }) {
    let fontStyle = styles.fontRegular;

    if (style?.fontWeight === "bold") {
        fontStyle = styles.fontBold;
    }
    
    return <Text style={[style, fontStyle]}>{ children }</Text>
}
