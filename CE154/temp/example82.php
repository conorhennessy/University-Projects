<?php
# Example 82
# Handy script to get a syntax error from Apache!
# All credit to Michael Petrov on
# http://php.net/manual/en/ref.errorfunc.php

error_reporting( E_ALL );
ini_set( 'display_errors', 'On' );

# We must set the following to the file we want to test:
include( 'example81.php' );
?>
