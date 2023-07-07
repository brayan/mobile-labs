import React from 'react';
import {
  SafeAreaView,
  StatusBar,
} from 'react-native';
import Basket from './src/presentation/Basket';
import mock from './src/mock/basket';

function App(): JSX.Element {
  return (
    <SafeAreaView style={{flex: 1}}>
      <StatusBar />
      <Basket {...mock} />
    </SafeAreaView>
  );
}

export default App;
