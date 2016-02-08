'use strict';

/* Controllers */

var simpleDemoControllers = angular.module('simpleDemoControllers', []);
var getAllReferencePath='/api/references';
var getReferencePath='/api/references';
var postReferencePath='/api/references';
var putReferencePath='/api/references';
var deleteReferencePath='/api/references';
simpleDemoControllers.controller(
	'ReferenceListCtrl',
	['$scope', '$http',
		function($scope,$http) {
			$http.get(getAllReferencePath).success(function(data) {
				$scope.referencesData = data;
				$scope.references=data.result;
			});
			$scope.applicationName = "My Simple Angular GUI for CRUD Interface";
			$scope.tableName='References';
			$scope.orderProp = 'id';
			
			$scope.create = function(oneReference) {
				$scope.master = angular.copy(oneReference);
				// Simple GET request example:
				$http({
					method: 'POST',
					data: oneReference,
					url: postReferencePath
				}).then(function successCallback(response) {
					$scope.references=response.data.result;
					// this callback will be called asynchronously
					// when the response is available
				}, function errorCallback(response) {
					$scope.requestError=response;
					// called asynchronously if an error occurs
					// or server returns response with an error status.
				});
			};
			$scope.deleteReference = function(refId) {
				// Simple GET request example:
				$http({
					method: 'DELETE',					
					url: deleteReferencePath+"/"+refId
				}).then(function successCallback(response) {
					$scope.references=response.data.result;
					// this callback will be called asynchronously
					// when the response is available
				}, function errorCallback(response) {
					$scope.requestError=response;
					$scope.requestId=deleteReferencePath+"/"+refId;
					// called asynchronously if an error occurs
					// or server returns response with an error status.
				});
			};
		}
	]
);
simpleDemoControllers.controller(
	'ReferenceUpdateCtrl',
	['$scope', '$routeParams','$http',
		function($scope,  $routeParams, $http) {
			$scope.applicationName = "My Simple Angular GUI for CRUD Interface";
			$scope.tableName='References';
			$scope.routeP=$routeParams;
			$scope.updId=$scope.routeP.refId;
			$scope.updateReferenceId=$routeParams.refId;				
			$scope.getUrl=getReferencePath+"/"+$routeParams.refId;
			$scope.putUrl=$scope.getUrl;
			$scope.tableName='References';
			$http({
				method: 'GET',					
				url: $scope.getUrl
			}).then(function successCallback(response) {
				$scope.result="Reference exists";
				//$scope.result1=$scope.getUrl;
				$scope.updateReference=response.data.result;
				// this callback will be called asynchronously
				// when the response is available
			}, function errorCallback(response) {
				$scope.error="Error!";
				$scope.response=response;
				//$scope.result1=$scope.getUrl;
				// called asynchronously if an error occurs
				// or server returns response with an error status.
			});
			$scope.update = function(updateReference) {
				// Simple GET request example:
				$http({
					method: 'PUT',
					data: updateReference,
					url: $scope.putUrl
				}).then(function successCallback(response) {
					$scope.result='Saved';
					// this callback will be called asynchronously
					// when the response is available
				}, function errorCallback(response) {
					$scope.error="Error!";
					$scope.response=response;
					// called asynchronously if an error occurs
					// or server returns response with an error status.
				});
			};
		}
	]
);
