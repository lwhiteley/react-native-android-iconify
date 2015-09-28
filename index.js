var { requireNativeComponent, PropTypes } = require('react-native');

var iface = {
    'IconTextView':{
        name: 'IconTextView',
        propTypes: {
            text: PropTypes.string,
        },
    }
};

module.exports = {
    IconTextView: requireNativeComponent('RCTIconTextView', iface['IconTextView'])
};