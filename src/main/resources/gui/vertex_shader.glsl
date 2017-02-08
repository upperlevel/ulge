#version 410 core

layout (location = 0) in vec2 position;
layout (location = 1) in vec2 itexCoord;

out vec2 texCoord;

uniform vec2 min;
uniform vec2 max;
uniform float depth = 0.0f;

void main()
{
    //TODO: include the vec(2) multiplication in the position!
    gl_Position = vec4(min + max * position * vec2(2) - vec2(1), depth, 1.0);
    texCoord = itexCoord;
}