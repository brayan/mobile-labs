import SwiftUI

class EmojiMemoryGame {
 
    private var model: MemoryGame<String> = MemoryGame<String>()
    
    var cards: Array<MemoryGame<String>.Card> {
        model.cards
    }
    
    func choose(card: MemoryGame<String>.Card) {
        model.choose(card: card)
    }
    
    
}
