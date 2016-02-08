'use strict';

/* App Module */

var simpleDemoApp = angular.module('simpleDemoApp', [
  'ngRoute',
  'simpleDemoControllers'
]);
simpleDemoApp.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/demo', {
        templateUrl: 'templates/references_list.html',
        controller: 'ReferenceListCtrl'
      }).
      when('/demo/reference/:refId', {
        templateUrl: 'templates/references_update.html',
        controller: 'ReferenceUpdateCtrl'
      }).
      otherwise({
        redirectTo: '/demo'
      });
  }]);
