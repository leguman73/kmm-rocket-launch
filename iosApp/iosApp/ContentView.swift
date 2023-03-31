import SwiftUI
import shared

struct ContentView: View {
    @ObservedObject private(set) var viewModel: ViewModel

    var body: some View {
        Text(viewModel.text)
    }
}

extension ContentView {
    class ViewModel: ObservableObject {
        @Published var text = "Loading..."
        init() {
            Greeting().greet { greeting, error in
                DispatchQueue.main.async {
                    if let greeting = greeting {
                        self.text = greeting
                    } else {
                        self.text = error?.localizedDescription ?? "error"
                    }
                }
            }

            RocketStorage().storeRockets(context: nil) { error in
                DispatchQueue.main.async {
                    if let error {
                        self.text = error.localizedDescription
                    } else {
                        self.text = (try? RocketStorage().readRockets(context: nil)) ?? "Couldn't read rocket file"
                    }
                }
            }
        }
    }
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
        ContentView(viewModel: ContentView.ViewModel())
	}
}
