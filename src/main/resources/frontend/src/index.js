import 'bootstrap/dist/css/bootstrap.min.css';
import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App';
import {BrowserRouter} from "react-router-dom";
import Header from "./components/ui/static-templates/Header";
import Footer from "./components/ui/static-templates/Footer";

const main = ReactDOM.createRoot(document.getElementById('main'));

main.render(
  <BrowserRouter>
      <Header/>
      <App/>
      <Footer/>
  </BrowserRouter>
);
