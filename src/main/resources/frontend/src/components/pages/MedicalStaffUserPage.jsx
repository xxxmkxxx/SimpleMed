import React from 'react';
import UserPage from "./UserPage";
import PatientActionsBar from "../ui/PatientActionsBar";
import PatientDataBlock from "../ui/PatientDataBlock";
import MedicalStaffDataBlock from "../ui/MedicalStaffDataBlock";
import MedicalStaffActionsBar from "../ui/MedicalStaffActionsBar";

class MedicalStaffUserPage extends React.Component {
    constructor(props, context) {
        super(props, context);

        this.state = {
            selector : "profile"
        }
    }

    changeSelector = (selector) => {
        this.setState({
            selector : selector
        });
    }

    chooseInfoBlock = (selector) => {
        let infoBlock;

        switch (selector) {
            case "profile": {
                infoBlock = <MedicalStaffDataBlock medicalStaffData={this.props.userInfo}/>
                break;
            }
        }

        return infoBlock;
    }

    render() {
        return (
            <div>
                <MedicalStaffActionsBar changeSelectorMethod={this.changeSelector}/>
                {this.chooseInfoBlock(this.state.selector)}
            </div>
        );
    }
}

export default MedicalStaffUserPage;