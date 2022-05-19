import React, {Component} from 'react';
import axios from "axios";
import {withRouter} from "react-router-dom";
import PatientUserPage from "./PatientUserPage";
import MedicalStaffUserPage from "./MedicalStaffUserPage";

class UserPage extends Component {
    constructor(props) {
        super(props);

        this.state = {
            userInfo : {
                userId: 2,
                name: "text",
                surname: "text",
                patronymic: "text",
                dateOfBirth: new Date().getDate(),
                sentReviews: [],
                recipientReviews: [],
                card: null,
                admissionRecords: []
            }
        };
    }


    async componentDidMount() {
        const userId = this.props.match.params.userId;
        const url = "http://localhost:8080/patient/" + userId;

        axios.get(url)
            .then(response => {
                console.log(response.data);

                this.setState({
                    userInfo : response.data
                });
            })
    }

    chooseUserPage = (type) => {
        let page;

        if (type === "patient") {
            page = <PatientUserPage userInfo={this.state.userInfo}/>
        } else if (type === "staff") {
            page = <MedicalStaffUserPage userInfo={this.state.userInfo}/>
        }

        return page;
    }

    render() {
        return (
            <div>
                {this.chooseUserPage("staff")}
            </div>
        );
    }
}

export default withRouter(UserPage);