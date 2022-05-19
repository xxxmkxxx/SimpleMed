import React, {Component} from 'react';
import UserDataBlock from "./UserDataBlock";
import InfoField from "./InfoField";

class MedicalStaffDataBlock extends Component {
    render() {
        return (
            <div>
                <UserDataBlock data={this.props.medicalStaffData}>
                    <InfoField fieldName="Должность" fieldText="text"/>
                    <InfoField fieldName="График работы" fieldText="text"/>
                    <InfoField fieldName="Кабинет" fieldText="text"/>
                </UserDataBlock>
            </div>
        );
    }
}

export default MedicalStaffDataBlock;