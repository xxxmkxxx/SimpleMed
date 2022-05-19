import React, {Component} from 'react';

class ProfileImg extends Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div>
                <img
                    height={this.props.height}
                    width={this.props.width}
                    src={this.props.url}
                    className="img-thumbnail"
                />
            </div>
        );
    }
}

export default ProfileImg;