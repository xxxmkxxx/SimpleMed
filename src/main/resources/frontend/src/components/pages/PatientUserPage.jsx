import React from 'react';
import PatientDataBlock from "../ui/PatientDataBlock";
import PatientActionsBar from "../ui/PatientActionsBar";

class PatientUserPage extends React.Component {
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
                infoBlock = <PatientDataBlock patientData={this.props.userInfo}/>
                break;
            }
        }

        return infoBlock;
    }

    render() {
        return (
            <div>
                <PatientActionsBar changeSelectorMethod={this.changeSelector}/>
                {this.chooseInfoBlock(this.state.selector)}
            </div>
        );
    }
}

export default PatientUserPage;