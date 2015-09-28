# react-native-android-iconify
icons for react native android using android-iconify

## Installation and How to use

#### Step 1 - NPM Install

```shell
npm install --save react-native-android-iconify
```
#### Step 2 - Update Gradle Settings

```gradle
// file: android/settings.gradle
...

include ':reacticonify', ':app'
project(':reacticonify').projectDir = new File(rootProject.projectDir, '../node_modules/react-native-android-iconify/app')
```

#### Step 3 - Update Gradle Build

```gradle
// file: android/app/build.gradle
...

dependencies {
    ...
    compile project(':reacticonify')
}
```

#### Step 4 - Register React Package

```java
...
import com.lwhiteley.reacticonify.ReactIconifyPackage; // import

public class MainActivity extends Activity implements DefaultHardwareBackBtnHandler {

    private ReactInstanceManager mReactInstanceManager;
    private ReactRootView mReactRootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mReactRootView = new ReactRootView(this);
        mReactInstanceManager = ReactInstanceManager.builder()
                .setApplication(getApplication())
                .setBundleAssetName("index.android.bundle")
                .setJSMainModuleName("index.android")
                .addPackage(new MainReactPackage())
                .addPackage(new ReactIconifyPackage()) // register react iconify package here
                .setUseDeveloperSupport(BuildConfig.DEBUG)
                .setInitialLifecycleState(LifecycleState.RESUMED)
                .build();
        mReactRootView.startReactApplication(mReactInstanceManager, "AwesomeProject", null);
        setContentView(mReactRootView);
    }
...

```

#### Step 5 - Require and use in Javascript

```js
// file: index.android.js

var React = require('react-native');
var { IconTextView } = require('react-native-android-iconify');
var { AppRegistry,StyleSheet,Text,View } = React;

var AwesomeProject = React.createClass({
    render: function() {
        return (
            <View style={styles.container}>
                <IconTextView text='{fa-facebook}' style={styles.icon} />
            </View>
        );
    }
});

var styles = StyleSheet.create({
  icon: {
    fontSize:40,
    color:'#0066FF',
  },
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  }
});

AppRegistry.registerComponent('AwesomeProject', () => AwesomeProject);
```

## Credits

- [android-iconify](https://github.com/JoanZapata/android-iconify)

## Notes
- only IconTextView was implemented so far, will implement the other widgets shortly
- all available icon modules of [android-iconify](https://github.com/JoanZapata/android-iconify) were included
- as seen above font size and color are controlled by css, all other features of [android-iconify](https://github.com/JoanZapata/android-iconify) remain the same
- Please report any issues or send patches to get fixes in