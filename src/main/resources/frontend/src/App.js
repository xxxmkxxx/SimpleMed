import React from "react";
import {Switch, Route} from "react-router-dom";
import UserPage from "./components/pages/UserPage";
import Test2 from "./components/pages/Test2";

function App() {
    return (
        <Switch>
            <Route exact={true} path="/">
                <Test2/>
            </Route>

            <Route path="/user/:userId/">
                <UserPage/>
            </Route>
        </Switch>
    );
}

export default App;
