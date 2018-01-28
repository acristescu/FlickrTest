# Flickr test

[![BuddyBuild](https://dashboard.buddybuild.com/api/statusImage?appID=5a6e1b525189b0000182adf1&branch=master&build=latest)](https://dashboard.buddybuild.com/apps/5a6e1b525189b0000182adf1/build/latest?branch=master)

This is a test I did for an interview for a company that shall remain nameless. It
is a one-screen app that consumes the Flickr public api and displays the images.
It allows search by tag and sorting. It uses Picasso to download and cache the
images.

Tech choices:

* Retrofit + OKHttp
* RxJava
* Dagger
* MVP architecture for testability
* Butterknife
* Local JUnit tests
* UI tests (Espresso)
* CI integration (including automatically running both JUnit and UI tests)
via BuddyBuild.

> Note: Please run the `prod` flavour to connect to Flickr, the `mock`
## Overview

Here is the diagram of the architecture proposed here:

![](https://cdn.rawgit.com/acristescu/GreenfieldTemplate/86c6e7a/architecture.svg)

The flow of events and data:

1. The __Activity__ reacts to the user input by informing the __Presenter__ that data is required.
1. The __Presenter__ fires off the appropriate request in the service layer (and instructs the __Activity__ to display a busy indicator).
1. The __Service__ then issues the correct REST call to the __Retrofit__ layer.
1. The __Retrofit__ layer exchanges HTTP requests and responses with the Server and returns an `Observable` (or perhaps `Single`).
1. The __Service__ possibly inspects the `Observable`, schedules it on the correct thread (in order to keep the __Presenter__ free of Android Schedulers and thus pure JUnit testable) and returns it back to the __Presenter__.
1. The __Presenter__ receives the `Observable`, retrieves the data or error and issues the correct commands to the __Activity__ to update the UI (and dismiss the busy indicator).
1. The __Activity__ presents the user with the data or error message.

## Testing strategy
The app has two kinds of tests: fast JUnit tests of the Presenter
layer (91% coverage) and UI tests for the most critical functionality. For testing
purposes some sample data has been hardcoded in the form of a JSON response.
This data is available to run the entire app if the app is build using the
`mock` flavour, while the `prod` flavour is used to connect to the actual
API. At this point running the UI tests only makes sense for the `mock`
flavour, although some end-to-end tests might be envisioned that could
run against the `prod` version to exercise the entire data flow.

## CI integration
This is setup via the BuddyBuild service (note that it will only work until
the 1st of March since the service will no longer be available). Any commit
to Git will automatically trigger a build and run all the tests (`testMockDebugUnitTest` and
`mockDebugAndroidTest` on a virtual Motorola Nexus 6 with API 23). A summary
of the results can be seen by clicking on the BuddyBuild badge at the top
of the README.