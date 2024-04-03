import logo from './logo.svg';
import './App.css';
import David from './David.png';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={David} className="App-logo" alt="logo" />
        <p>
          Welcome to React App with Docker and Github Acctions
        </p>
        <p>
          This should be deployed to AWS using Github Actions
        </p>
        <a
          className="App-link"
          href="https://github.com/DaniDevOfficial"
          target="_blank"
          rel="noopener noreferrer"
        >
          Checkout my Github
        </a>

        <a>
          I love la gyato
        </a>
      </header>
    </div>
  );
}

export default App;
