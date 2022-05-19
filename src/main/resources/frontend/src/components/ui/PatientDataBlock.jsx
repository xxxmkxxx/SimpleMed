import React, {Component} from 'react';
import UserDataBlock from "./UserDataBlock";
import InfoField from "./InfoField";

class PatientDataBlock extends Component {
    render() {
        return (
            <div>
                <UserDataBlock data = {this.props.patientData}>
                    <InfoField fieldName="Рост" fieldText="text"/>
                    <InfoField fieldName="Вес" fieldText="text"/>
                    <InfoField fieldName="Дата рождения" fieldText={this.props.patientData.dateOfBirth}/>
                </UserDataBlock>
            </div>
        );
    }
}

export default PatientDataBlock;