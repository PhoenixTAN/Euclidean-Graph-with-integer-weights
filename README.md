# Euclidean-Graph-with-integer-weights
Yield a euclidean graph with all its weights which are integers. All vertices cannot be in one line.

Definition of Euclidean Graph:  
A Euclidean graph is a graph in which the vertices represent points in the plane,   
and the edges are assigned lengths equal to the Euclidean distance between those points.  

Example:  
(49, 47)  
(85, 32)  
(49, 17)  
(29, 32)  
Distance between Point 0 and Point 1 39.0  
Distance between Point 0 and Point 2 30.0  
Distance between Point 0 and Point 3 25.0  
Distance between Point 1 and Point 2 39.0  
Distance between Point 1 and Point 3 56.0  
Distance between Point 2 and Point 3 25.0  
  
%% Matlab Visualization code  
x = [ 49 85 49 29 ];  
y = [ 47 32 17 32 ];  
distanceMat = pdist( [   
49, 47;  
85, 32;  
49, 17;  
29, 32;  
] )  
scatter(x, y);  
