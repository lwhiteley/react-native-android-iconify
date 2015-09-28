var { requireNativeComponent, PropTypes } = require('react-native');

var iface = {
    'IconTextView':{
        name: 'IconTextView',
        propTypes: {
            text: PropTypes.string,
        }
    },
    'IconButton':{
        name: 'IconButton',
        propTypes: {
            text: PropTypes.string,
        }
    },
    'IconToggleButton':{
        name: 'IconToggleButton',
        propTypes: {
            text: PropTypes.string,
            textOn: PropTypes.string,
            textOff: PropTypes.string,
        }
    }
};

module.exports = {
    IconTextView: requireNativeComponent('RCTIconTextView', iface['IconTextView']),
    IconButton: requireNativeComponent('RCTIconButton', iface['IconButton']),
    IconToggleButton: requireNativeComponent('RCTIconToggleButton', iface['IconToggleButton'])
};