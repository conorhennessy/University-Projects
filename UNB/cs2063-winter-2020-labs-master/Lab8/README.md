# Lab 8 - Gestures and Animations

## Pair Programming

We will again be doing pair programming for this lab.  Details on pair programming can be found at [Pair Programming](../docs/PAIR_PROGRAMMING.md).  You can again work with anybody of your choosing.

**To receive credit for this lab you must pair program.**

**Switch between the roles of navigator and driver every 10 to 15
minutes.**

## Introduction
In lecture we've seen how to detect gestures, create animations, and play sounds. In this lab we'll put these pieces together to create a game-like app.

The game begins with a blank screen with the following actions that can be performed.

* Tapping on the screen will create a bubble at that location
  * The bubble will have a random size, rotation, and direction of movement
* Tapping on a bubble will pop it and play a popping sound
* Starting a fling gesture on a bubble will fling that bubble off the screen at a velocity determined by the fling gesture
* If left alone a bubble will eventually move off the screen
* A counter at the bottom of the screen keeps track of the number of bubbles on the screen


## Useful Links

* [SoundPool](http://developer.android.com/reference/android/media/SoundPool.html)
Also see the `SoundPool` example in the course GitHub repository.
* [MotionEvent](http://developer.android.com/reference/android/view/MotionEvent.html)
* See the `GestureDetector` examples [here](http://developer.android.com/training/gestures/detector.html) and in the course GitHub repository for how to delegate `MotionEvent`s.
* See the [Random](https://docs.oracle.com/javase/6/docs/api/java/util/Random.html) API details for information on generating random numbers in Java.
* [BitMap](http://developer.android.com/reference/android/graphics/Bitmap.html) - including how to create a scaled `Bitmap`
* [Canvas](http://developer.android.com/reference/android/graphics/Canvas.html)


**Lab Todo**

Examine the code to get an understanding of what's already implemented. You don't need to understand every line, but should understand the overall structure of the app.
This lab requires you to learn independently and read lots of documentation. The help section below gives you some pointers. Ask questions if you get stuck!

Complete the TODOs in `BubbleActivity` **by pair programming**.

Have fun!

**Lab Completion**

* Show the working app to the instructor or TA using the following scenarios
* Keep a copy of your project work and answers for future reference

## Credits

This lab is based on materials from [Adam Porter](https://github.com/aporter).
