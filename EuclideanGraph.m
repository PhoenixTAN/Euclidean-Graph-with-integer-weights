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
