# VOnResult
[ ![Download](https://api.bintray.com/packages/vdreamers/maven/VOnResult/images/download.svg) ](https://bintray.com/vdreamers/maven/VOnResult/_latestVersion)

<a href='https://bintray.com/vdreamers/maven/VOnResult?source=watch' alt='Get automatic notifications about new "VOnResult" versions'><img src='https://www.bintray.com/docs/images/bintray_badge_color.png'></a>


VOnResult is try to avoid onActivityResult.

## Gradle

AndroidX:

```gradle androidx
compile 'com.vdreamers.vonresult:v-onresult:1.0.2'
```

Support:

```gradle support
compile 'com.vdreamers.vonresult.support:v-onresult-support:1.0.2'
```

## How to Use

```how to use
OnResult.of(activity or fragment)
        .start(intent, request, new OnResultCallBack() {
            @Override
            public void onActivityResult(int requestCode, int resultCode, Intent data) {
                // do something
            }
         });
```


## [ChangeLog](CHANGELOG.md)

