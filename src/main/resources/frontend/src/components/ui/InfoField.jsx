import React, {Component} from 'react';

class InfoField extends Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div>
                <div>
                    {this.props.fieldName}: {this.props.fieldText}
                </div>
            </div>
        );
    }
}

export default InfoField;
