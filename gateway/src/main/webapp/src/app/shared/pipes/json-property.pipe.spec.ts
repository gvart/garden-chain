import { JsonPropertyPipe } from './json-property.pipe';

describe('JsonPropertyPipe', () => {
  it('create an instance', () => {
    const pipe = new JsonPropertyPipe();
    expect(pipe).toBeTruthy();
  });
});
