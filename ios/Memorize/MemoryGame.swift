import Foundation

struct MemoryGame<CardContent> {
    var cards = Array<Card>()
    
    // allow structs to mutade the self
    mutating func choose(card: Card) {
        print("card chosen: \(card)")
        let chosenIndex: Int = self.index(of: card)
        let chosenCard: Card = self.cards[chosenIndex]
        
    }
    
    func index(of: Card) -> Int {
        // TODO
        return 0
    }
    
    // all inits are mutating
    init(numberOfPairsOfCards: Int, cardContentFactory: (Int) -> CardContent) {
        cards = Array<Card>()
        for pairIndex in 0..<numberOfPairsOfCards {
            let content = cardContentFactory(pairIndex)
            cards.append(Card(id: (pairIndex * 2), content: content))
            cards.append(Card(id: (pairIndex * 2 + 1), content: content))
        }
    }
    
    // structs are value types.. they are created every time when passed as a parameter to a function
    struct Card: Identifiable {
        var id: Int
        var isFaceUp: Bool = true
        var isMatched: Bool = false
        var content: CardContent
    }
}

