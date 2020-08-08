import SwiftUI

// struct is a container for variables, functions...
struct ContentView: View {
    // any type of View
    var body: some View {
        HStack( content: {
            ForEach(0..<4) { index in
                CardView(isFaceUp: true)
            }
        })
            .padding()
            .foregroundColor(Color.orange)
            .font(Font.largeTitle)
    }
}

struct CardView: View {
    var isFaceUp: Bool
    var body: some View {
        ZStack(content: {
            if isFaceUp {
                RoundedRectangle(cornerRadius: 10.0).fill(Color.white)
                RoundedRectangle(cornerRadius: 10.0).stroke(lineWidth: 3)
                Text("👻")
            } else {
                RoundedRectangle(cornerRadius: 10.0).fill(Color.orange)
            }
        })
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}