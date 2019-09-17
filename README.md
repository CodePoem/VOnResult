# VOnResult

[ ![Download](https://api.bintray.com/packages/vdreamers/maven/VOnResult/images/download.svg) ](https://bintray.com/vdreamers/maven/VOnResult/_latestVersion)

<a href='https://bintray.com/vdreamers/maven/VOnResult?source=watch' alt='Get automatic notifications about new "VOnResult" versions'><img src='https://www.bintray.com/docs/images/bintray_badge_color.png'></a>

[English](README_EN.md)

VOnResult 用于尝试避免 onActivityResult 断崖式回调。

## Gradle

AndroidX:

```gradle androidx
implementation 'com.vdreamers.vonresult:v-onresult:1.0.2'
```

Support:

```gradle support
implementation 'com.vdreamers.vonresult.support:v-onresult-support:1.0.2'
```

## 如何使用

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

